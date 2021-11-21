package com.manisrini.domain.java8.collections.hashmapfeature;

import static java.util.Map.Entry.comparingByValue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.manisrini.domain.FileProperty;

public class ToMapAndReduceAndSorting {

  private int calculateTotalNoOfFileSizeForGivenNoOfCollection(List<FileProperty> attributeList, int requiredNoOfCollection) {

    // Take the List and create a map using collectionId as key and filesize as value
    // while doing that process, if Collectors.toMap function finds duplicate key then BinaryOperator (extends BiFunction) gets executed.
    // what BinaryOperator does? it takes two parameters and returns one value. meaning, takes 2 keys and prepare one and return
    // In this case, if toMap finds duplicate key then it sums up both values as part of merger BinaryOperator BiFunction
    Map<String, Integer> filesGroupByCollectionIdAndSize = attributeList.stream().collect(Collectors
        .toMap(FileProperty::getCollectionId, FileProperty::getFileSize, (value1, value2) -> value1 + value2));

    System.out.println("Created Map:" + filesGroupByCollectionIdAndSize);

    // Sorting the map comparingByValue in reverse order and collect it in LinkedHashMap to maintain insertion order
    // Note: In Collectors.toMap, you get Entry object, so Entry::getKey, Entry::getValue
    // he merger BinaryOperator BiFunction will not be executed though it returns 0 as there is no duplicate key, because it is already a map so duplicate key not possible.
    Map<String, Integer> sortedByFileSizeDescending = filesGroupByCollectionIdAndSize.entrySet()
        .stream()
        .sorted(Collections.reverseOrder(comparingByValue()))
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (value1, value2) -> 0, LinkedHashMap::new));

    System.out.println("SortedByFileSizeDescending:" + sortedByFileSizeDescending);

    // here we take top requiredNoOfCollection limit value
    Map<String, Integer> limitedRequiredNoOfCollection = sortedByFileSizeDescending.entrySet().stream().limit(requiredNoOfCollection)
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (value1, value2) -> 0, LinkedHashMap::new));

    System.out.println("LimitedNoOfCollection:" + limitedRequiredNoOfCollection);

    return limitedRequiredNoOfCollection.values().stream().mapToInt(Integer::intValue).sum();
  }

  private int calculateTotalNoOfFileSizeForMultipleCollectionIds(List<FileProperty> attributeList, int requiredNoOfCollection) {

    HashMap<String, Integer> filesGroupByCollectionIdAndSize = attributeList.stream()
        .reduce(new HashMap<>(), (fileMap, fileAttribute) -> {
          fileAttribute.getCollectionIds().forEach(it -> {
            fileMap.merge(it, fileAttribute.getFileSize(), (oldval, newval) -> oldval + newval);
          });
          return fileMap;
        }, (oldMap, newMap) -> {
          newMap.putAll(oldMap);
          return newMap;
        });
    System.out.println("filesGroupByCollectionIdAndSize:" + filesGroupByCollectionIdAndSize);
    return 0;
  }

  public static void main(String[] args) {
    ToMapAndReduceAndSorting processor = new ToMapAndReduceAndSorting();

    List<FileProperty> fileWithSingleCollectionId =
        Arrays.asList(
            buildFile("file1", 100, "1"),
            buildFile("file2", 200, "1"),
            buildFile("file3", 300, "1"),
            buildFile("file4", 400, "2"),
            buildFile("file5", 400, "2"),
            buildFile("file6", 500, "3"),
            buildFile("file7", 600, "4"),
            buildFile("file8", 700, "5"),
            buildFile("file9", 700, "5"),
            buildFile("file10", 800, "6"),
            buildFile("file11", 900, "7"),
            buildFile("file12", 1000, "8")
            );

    System.out.println(processor.calculateTotalNoOfFileSizeForGivenNoOfCollection(fileWithSingleCollectionId, 5));
    System.out.println(processor.calculateTotalNoOfFileSizeForGivenNoOfCollection(fileWithSingleCollectionId, 2));

    List<FileProperty>  fileWithMultipleCollectionIds =
        Arrays.asList(
            buildFile("file1", 100, "1","2"),
            buildFile("file2", 200, "1","3"),
            buildFile("file3", 300, "3","5")
        );

    System.out.println(processor.calculateTotalNoOfFileSizeForMultipleCollectionIds(fileWithMultipleCollectionIds, 1));
  }

  private static FileProperty buildFile(String fileName, int fileSize, String collectionId) {
    FileProperty fileProperty = new FileProperty();
    fileProperty.setFileName(fileName);
    fileProperty.setFileSize(fileSize);
    fileProperty.setCollectionId(collectionId);
    return fileProperty;
  }

  private static FileProperty buildFile(String fileName, int fileSize, String ... collectionIds) {
    FileProperty fileProperty = new FileProperty();
    fileProperty.setFileName(fileName);
    fileProperty.setFileSize(fileSize);
    fileProperty.setCollectionIds(Arrays.asList(collectionIds));
    return fileProperty;
  }
}
