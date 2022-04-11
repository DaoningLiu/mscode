package com.chinatechstar.door.service;

import java.util.Map;

public interface DoorService {

    Map queryApplyDetail(Map<String, String> stringMap) throws Exception;

    Map applyArchiveBorrow(Map<String, String> stringMap) throws Exception;

    Map applyCHSandSI(Map<String, String> stringMap) throws Exception;

    Map applyInspect(Map<String, String> stringMap) throws Exception;

    Map commitTime(Map<String, String> stringMap) throws Exception;

    Map applyFileCommitment(Map<String, String> stringMap) throws Exception;

    Map applyCopy(Map<String, String> stringMap) throws Exception;

    Map supplementaryDossier(Map<String, String> stringMap) throws Exception;

    Map getPersonInfo(Map<String, String> stringMap) throws Exception;

    Map applyFileTransfer(Map<String, String> stringMap)throws Exception ;

    Map issueProve(Map<String, String> stringMap) throws Exception;

    Map queryApply(Map<String, String> stringMap) throws Exception;
}
