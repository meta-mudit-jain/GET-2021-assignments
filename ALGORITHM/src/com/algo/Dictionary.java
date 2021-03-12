package com.algo;

import java.util.*;
public interface Dictionary {
    public void addKey(String key,String value);
    public void deleteKey(String key);
    public String getValue(String key);
    public List<Node> sortedPrint();
    public List<Node> sortedPrintBetweenValues(String k1,String k2);
}
