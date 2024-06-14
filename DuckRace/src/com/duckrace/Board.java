package com.duckrace;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


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

public class Board implements Serializable {
    public static final String DATA_FILE_PATH = "data/board.dat";
    public static final String STUDENT_ID_FILE_PATH = "conf/student-ids.cvs";

    /*
     * Read from binary file data or create new Board if file not there
     */
    public static Board getInstance() {
        Board board = null;
        if (Files.exists(Path.of(DATA_FILE_PATH))) {
            try (ObjectInputStream in = new  ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
              board = (Board) in.readObject();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            board = new Board();
        }
        return board;
    }

    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap = new TreeMap<>();

    // prevent instantiation from the outside
    private Board(){
    }

    // TESTING PURPOSES
//    void dumpStudentIdMap(){
//        System.out.println(studentIdMap);
//    }


    /*
     * This shows the data to the human user
     * We need to show the right side of the map, Ideally in an attractive way
     */




    public void show(){
        if(racerMap.isEmpty()){
            System.out.println("No Current results to show");
            System.out.println();
        }
        else {
            Collection<DuckRacer> racers = racerMap.values();

            System.out.println("id   name    wins    rewards");
            System.out.println("--   ----    ----    -------" );

            for (DuckRacer racer : racers) {
                System.out.printf("%s   %s    %s      %s\n",
                        + racer.getId(), racer.getName(), racer.getWins(), racer.getRewards());
            }
        }
    }


    /*
     * Update the board (racerMap) by making a DuckRacer win.
     * This could mean fetching an existing DuckR acer from the racerMap
     * or we might need to create a new DuckRacer, put it in the map, and then make it win
     * Either way, it needs to win!
     */
    public void update(int id, Reward reward){
        DuckRacer racer = null;

        if (racerMap.containsKey(id)) { // fetch existing DuckRacer
            racer.win(reward);
        }
        else {                      // create new DuckRacer
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id,racer);
        }
        racer.win(reward);
        save();
    }


    public void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE_PATH))){
        out.writeObject(this);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
     * Populates studentID Map from file conf/student-ids.csv
     */

    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer,String> map = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(STUDENT_ID_FILE_PATH));
            // for each line (String), we need to split it into "tokens" based on the comma
            for(String line : lines) {
                String[] tokens = line.split(",");
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                map.put(id, name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }
}