package com.duckrace;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.nio.file.Files;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

class Board {
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = null;

    public void update(int id, Reward reward){
        if (racerMap.containsKey(id)){
            DuckRacer racer = racerMap.get(id);
            racer.win(reward);
        }
        else {
            DuckRacer racer = new DuckRacer(id,studentIdMap.get(id));
            racerMap.put(id, racer);
            racer.win(reward);
        }
    }

    void dumpRacerMap(){
        System.out.println();
    }
//
//    void dumpStudentIdMap(){
//        System.out.println();
//    }

    private Map<Integer,String> loadStudentIdMap() {
        Map<Integer,String> map = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.cvs"));
            for (String line: lines){
                String[] tokens = line.split(",");
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                map.put(id,name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}