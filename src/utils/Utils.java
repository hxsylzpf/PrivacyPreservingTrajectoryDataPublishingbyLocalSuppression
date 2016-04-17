package utils;

import models.RawDataModel;
import models.SensitiveDataModel;
import models.TrajectoryDataModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Created by Araja Jyothi Babu on 15-Apr-16.
 */
public class Utils {
    //global functions for use all over project

    public static SensitiveDataModel makeSensitiveDataModel(ResultSet rs) throws Exception{
        return new SensitiveDataModel(rs.getInt(1), rs.getString(2));
    }

    public static TrajectoryDataModel makeTrajectoryDataModel(ResultSet rs) throws Exception {
        return new TrajectoryDataModel(rs.getInt(1), rs.getString(2), rs.getString(3));
    }

    public static RawDataModel makeRawDataModel(ResultSet rs) throws Exception {
        return new RawDataModel(rs.getInt(1), rs.getString(2), rs.getString(3));
    }

    public static String makeDoublet(TrajectoryDataModel trajectoryDataModel) throws Exception {
        return trajectoryDataModel.getLocation() + "" + trajectoryDataModel.getTime();
    }

    public static String makeDoublet(ResultSet rs) throws Exception {
        return rs.getString(1) + rs.getString(2);
    }

    public static String makeSingleString(ArrayList<String> doublets) throws Exception {
        StringBuilder path = new StringBuilder("");
        int length = doublets.size();
        for(String doublet : doublets){
            path.append(doublet + (length != 1 ? "-" : ""));
            length--;
        }
        return path.toString();
    }

    public static String makeSingleString(ArrayList<String> doublets, int except) throws Exception {
        StringBuilder path = new StringBuilder("");
        int length = except;
        for(String doublet : doublets){
            path.append(doublet + (length != 1 ? "-" : ""));
            length--;
        }
        return path.toString();
    }

    public static ArrayList<String> uniqueList(ArrayList<String> strings){
        ArrayList<String> uniqueList = new ArrayList();
        HashSet<String> set = new HashSet(strings);
        for(String s : set){
            uniqueList.add(s);
        }
        return uniqueList;
    }

    public static ArrayList<String> arrayToArrayList(String[] array){
        ArrayList<String> strings = new ArrayList();
        for(String s : array){
            strings.add(s);
        }
        return strings;
    }

}
