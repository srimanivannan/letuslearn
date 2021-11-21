package com.manisrini.domain.interview.assessments.atlassian;

import static java.util.Map.Entry.comparingByValue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileSizeProcessor {

  // Validate File attribute atleast one file
  // Total File size
  // validate sorting happening
  // limit of no of collectionId
  // validate map exception if no > size or not
  private int calculateTotalNoOfFileSize(List<FileAttribute> attributeList) {
    int total = 0;
    for (FileAttribute attribute: attributeList) {
      total = total + attribute.getFileSize();
    }
    Integer collect = attributeList.stream().collect(Collectors.summingInt(it -> it.getFileSize()));
    System.out.println(collect);
    return total;
  }

  private String calculateTotalNoOfFileSize(List<FileAttribute> attributeList, int requiredNoOfCollection) {
    Integer sum = attributeList.stream().mapToInt(FileAttribute::getFileSize).sum();
    System.out.println(sum);

    Map<String, Integer> collect =  new HashMap<>();

    for (FileAttribute attribute: attributeList) {
      if (collect.containsKey(attribute.getCollectionId())) {
        Integer oldSize = collect.get(attribute.getCollectionId());
        collect.put(attribute.getCollectionId(), attribute.getFileSize() + oldSize);
      } else {
        collect.put(attribute.getCollectionId(), attribute.getFileSize());
      }
    }
    Map<String, Integer> collect2 = attributeList.stream().collect(Collectors
        .toMap(FileAttribute::getCollectionId, FileAttribute::getFileSize, Integer::sum));

    System.out.println(collect2);
    Map<String, Integer> sorted = collect.entrySet()
        .stream()
        .sorted(Collections.reverseOrder(comparingByValue()))
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

    Map<String, Integer> collect1 = sorted.entrySet().stream().limit(requiredNoOfCollection)
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    System.out.println(collect1);
    return "";
  }

  public static void main(String[] args) {
    FileSizeProcessor processor = new FileSizeProcessor();
    List<FileAttribute> attributeList =
        Arrays.asList(buildFile("file1", 100, "1"), buildFile("file1", 100, "2"));

    //int total = processor.calculateTotalNoOfFileSize(attributeList);
    //System.out.println(total);

    List<FileAttribute> collectList =
        Arrays.asList(buildFile("file2", 200, "1"), buildFile("file3", 200, "1"), buildFile("file4", 300, "2"));

    processor.calculateTotalNoOfFileSize(collectList, 1);

  }

  private static FileAttribute buildFile(String fileName, int fileSize, String collectionId) {
    FileAttribute fileAttribute = new FileAttribute();
    fileAttribute.setFileName(fileName);
    fileAttribute.setFileSize(fileSize);
    fileAttribute.setCollectionId(collectionId);
    return fileAttribute;
  }
}

