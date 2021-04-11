# java threading concepts and understanding
## Deadlock

### Liveness
``` 
Ability to run multithreaded program to run promptly
```
### deadlock
```
Situation where 2 or more threads are blocked forever, waiting for each other.
```
### Livelock
```
Situation where 2 or more threads are caught in an infinite loop cycle of responding each other.
```
### Starvation
```log
Situation where 2 or more threads are unable to make progress of another `greedy` thread
```

## New classes for locking on java.util.concurrent
```
Lock --> Interface 
ReenrantLock --> implements Lock Interface
ReadWriteLock --> like Lock but seperate read operations from write
Condition
```
## Volatile keyword
```
An indication to jvm that multiple threads may try to access/update the fields at same time.
jvm immediately flushes out value when changes so that later thread see the latest value
Allows limited safe concurrent access
doen't solve concurrency
```
## Object lock methods
```
notify() --> unblock one random thread waiting on the objects lock based on thread priority
notifyAll() --> 
wait()
wait(ms)
```