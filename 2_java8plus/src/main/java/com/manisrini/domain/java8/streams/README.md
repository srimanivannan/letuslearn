## Points to Remember in Streams

### Type of Streams
    1. Stream
    2. IntStream
    3. DoubleStream
    4. LongStream

### Notes
```
IntStream doesn't have collect(Collector), so you will have to convert it to Stream 
and then collect to list or any collection
```

```
IntStream has sum, average terminal operations, regular Stream doesn't have.
you will have to convert regular Stream to IntStream
```