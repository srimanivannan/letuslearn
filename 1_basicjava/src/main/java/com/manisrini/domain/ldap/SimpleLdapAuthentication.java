/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cacheloc.ldap;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class SimpleLdapAuthentication
{
	public static void main(String[] args)
	{
		String username = "mani";
		String password = "Test123!";
		String base = "ou=users,dc=example,dc=com";
		String dn = "uid=" + username + "," + base;
		String ldapURL = "ldap://localhost:10389";
                //uid=mani,ou=users,dc=example,dc=com
		// Setup environment for authenticating
		
		Hashtable<String, String> environment = 
			new Hashtable<String, String>();
		environment.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		environment.put(Context.PROVIDER_URL, ldapURL);
		environment.put(Context.SECURITY_AUTHENTICATION, "simple");
		environment.put(Context.SECURITY_PRINCIPAL, dn);
		environment.put(Context.SECURITY_CREDENTIALS, password);

		try
		{
			DirContext authContext = 
				new InitialDirContext(environment);
			
			// user is authenticated
			
		}
		catch (AuthenticationException ex)
		{
			ex.printStackTrace();
			// Authentication failed

		}
		catch (NamingException ex)
		{
			ex.printStackTrace();
		}
	}
}
