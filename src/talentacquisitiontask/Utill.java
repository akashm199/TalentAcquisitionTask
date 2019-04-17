/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talentacquisitiontask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Akash Mishra
 */
public class Utill {

    public static String[] readLine(String filePath) {
        String[] data = null;
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(filePath));
            int i = 1;
            while ((line = br.readLine()) != null) {
                if (i == 1) {
                    data = line.split(",");
                }
                i++;
            }

        } catch (IOException e) {
            data = null;
            System.out.println("Excetipon :: " + e);
        }
        return data;
    }

    public static boolean validateColom(String str, String[] colomnA, String[] colomnB) {
        boolean flag = false;
        String txt = str.toLowerCase().trim();
        try {
            for (String colomnA1 : colomnA) {
                flag = txt.equalsIgnoreCase(colomnA1);
                if (flag) {
                    break;
                }
            }
            if (flag) {
                for (String colomnB1 : colomnB) {
                    flag = txt.equalsIgnoreCase(colomnB1);
                    if (flag) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            flag = false;
            System.out.println("Excetipon :: " + e);
        }
        return flag;
    }

    public static void createCSV(String outputPath, String data) {
        try (PrintWriter writer = new PrintWriter(new File(outputPath + File.separator + "final.csv"))) {
            writer.write(data);
            System.out.println("done!");
        } catch (FileNotFoundException e) {
            System.out.println("Exception :: " + e.getMessage());
        }
    }

    public static String getData(String joinstr, String filePathA, String filePathB, String[] colomnA, String[] colomnB) throws IOException {
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for (String clmA : colomnA) {
            sb.append(clmA);
            sb.append(",");
        }
        int i = 1;
        for (String clmB : colomnB) {
            if (joinstr.trim().equalsIgnoreCase(clmB)) {
            } else {
                sb.append(clmB);
                if (i == colomnB.length) {
                } else {
                    sb.append(",");
                }
            }
            i++;
        }
        BufferedReader br1 = null;
        BufferedReader br2 = null;
        String line = "";
        String line1 = "";
        br1 = new BufferedReader(new FileReader(filePathA));
        br2 = new BufferedReader(new FileReader(filePathB));
        int j = 1;
        int i1 = -1;
        int i2 = -1;
        String[] data2 = null;
        String[] data3 = null;
        while ((line = br1.readLine()) != null) {
            StringBuffer sb1 = new StringBuffer();
            String[] data = null;
            if (j == 1) {
                data2 = line.split(",");
                if ((line1 = br2.readLine()) != null) {
                    data3 = line1.split(",");
                }
            } else {
                i1 = find(data2, joinstr);
                i2 = find(data3, joinstr);
                data = line.split(",");
                if (i1 > -1 && i2 > -1) {
                    int t = 1;
                    String line2 = "";
                    String[] data5 = null;
                    BufferedReader br3 = new BufferedReader(new FileReader(filePathB));
                    while ((line2 = br3.readLine()) != null) {
                        if (t == 1) {
                        } else {
                            data5 = line2.split(",");
                            if (data[i1].equalsIgnoreCase(data5[i2])) {
                                sb1.append("\n");
                                int z = 1;
                                for (String d : data) {
                                    sb1.append(d);
                                    sb1.append(",");
                                    z++;
                                }
                                z = 1;
                                for (String d : data5) {
                                    if (!d.equalsIgnoreCase(data5[i2])) {
                                        sb1.append(d);
                                        if (z == data5.length) {
                                        } else {
                                            sb1.append(",");
                                        }
                                    }
                                    z++;
                                }
                            }
                        }
                        t++;
                    }
                }
            }
            j++;
            sb2.append(sb1.toString());
        }
        String dataFinal = sb.toString() + "" + sb2.toString();
        return dataFinal;
    }

    public static int find(String[] a, String target) {
        int i = 0;
        for (String str : a) {
            if (str.equalsIgnoreCase(target)) {
                break;
            } else {
                i++;
            }

        }
        return i;
    }
}
