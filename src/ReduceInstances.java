import java.io.*;
import java.util.ArrayList;

public class ReduceInstances {

        public static void main(String args[]){
            int count = 0, countNull = 0;
            boolean value =false;
            ArrayList<String> b = new ArrayList<>();

            String configFileName = "C:/Users/jc428329/Downloads/final(allattributes).arff", splitCSVBy = ",";
            try (BufferedReader reader = new BufferedReader(new FileReader(configFileName))) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/jc428329/Downloads/deathsOnlyQLD.arff", true));
                String line;
                while ((line = reader.readLine()) !=null) {
                    count++;

                    String[] attributeList = line.split(splitCSVBy);
                    if (attributeList[0].contains("@")){
                        writer.append(line + "\n");
                    }
                    if (attributeList[0].equals("@data")) {
                        value = true;
                        continue;
                    }
                    if (value){
                        if (attributeList[1].contains("Fatal")){
                            writer.append(line + "\n");

                        }else countNull++;
                    }
                }
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
                System.out.println("couldnt find file");
            }catch (ArrayIndexOutOfBoundsException a){
                a.printStackTrace();
                System.out.println("array exception");
            }
        }
}
