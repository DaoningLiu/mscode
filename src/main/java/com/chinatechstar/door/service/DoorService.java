package com.chinatechstar.door.service;

import java.util.Map;

public interface DoorService {

    Map queryApplyDetail(Map<String, String> stringMap) throws Exception;
    Map applyArchiveBorrow(Map<String, String> stringMap) throws Exception;
    Map applyCHSandSI(Map<String, String> stringMap) throws Exception;
    Map applyInspect(Map<String, String> stringMap) throws Exception;
    Map commitTime(Map<String, String> stringMap) throws Exception;
}
