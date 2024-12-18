package org.me.sharedresources;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {

    public static volatile SharedResource sharedResource;

    private static List<Integer> integerList = new ArrayList<>();

    private SharedResource(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public static SharedResource getInstance(List<Integer> integerList) {
        synchronized (SharedResource.class) {
            if (sharedResource == null) {
                sharedResource = new SharedResource(integerList);
            }
            return sharedResource;

        }


    }

    public List<Integer> removeElement(Integer integer) {
        integerList.removeIf(e -> e.equals(integer));
        return integerList;
    }

    ;

    public List<Integer> addElement(Integer integer) {
        integerList.add(integer);
        return integerList;
    }

    ;

}
