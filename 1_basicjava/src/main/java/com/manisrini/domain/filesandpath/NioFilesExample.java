package com.manisrini.domain.filesandpath;

import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import io.vavr.control.Try;


public class NioFilesExample {

  public void filesCreateTempFile() {
    Path file = Try.of(() ->Files.createTempFile("master", ".txt")).get();
    System.out.println(file);
    ///var/folders/qz/s0hsv0jj3h30c2z9f8z58hym0000gn/T/master16600760185564249106.txt
  }

  public void fileLines() {
    Path path = Try.of(() -> Paths.get(getClass().getClassLoader().getResource("java7filetest2.txt").toURI())).get();
    Stream<String> lines = Try.of(() -> Files.lines(path)).get();
    lines.forEach(System.out::println);
  }

  public void fileReadAllLines()  {
    Path path = Try.of(() -> Paths.get(getClass().getClassLoader().getResource("java7filetest3.txt").toURI())).get();
    List<String> readAllLines = Try.of(() -> Files.readAllLines(path)).get();
    System.out.println(readAllLines);
  }

  public void fileReadString()  {
    Path path = Try.of(() -> Paths.get(getClass().getClassLoader().getResource("java7filetest3.txt").toURI())).get();
    String s = Try.of(() -> Files.readString(path)).get();
    System.out.println(s);
  }

  public void fileGetFileStore()  {
    Path path = Try.of(() -> Paths.get(getClass().getClassLoader().getResource("java7filetest3.txt").toURI())).get();
    FileStore store = Try.of(() -> Files.getFileStore(path)).get();
    System.out.println(store.type());
  }

  public void fileReadAllBytesAndWrite()  {
    Path inputSource = Try.of(() -> Paths.get(getClass().getClassLoader().getResource("hello.pdf").toURI())).get();
    byte[] bytes = Try.of(() -> Files.readAllBytes(inputSource)).get();
    Path outSource = Try.of(() -> Files.createTempFile("hello1", ".pdf")).get();
    Path outputSource = Try.of(() -> Files.write(outSource, bytes)).get();
    System.out.println(outputSource);
  }

  public static void main(String[] args) {
    NioFilesExample nioFilesExample = new NioFilesExample();
    nioFilesExample.filesCreateTempFile();
    nioFilesExample.fileLines();
    nioFilesExample.fileReadAllLines();
    nioFilesExample.fileReadString();
    nioFilesExample.fileGetFileStore();
    nioFilesExample.fileReadAllBytesAndWrite();
  }
}
