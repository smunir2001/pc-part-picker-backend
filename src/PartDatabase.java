import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PartDatabase {
    private ArrayList<PCComponent> components = new ArrayList<PCComponent>();
    private ArrayList<CasePart> Case = new ArrayList<CasePart>();
    private ArrayList<CPUPart> CPUs = new ArrayList<CPUPart>();
    private ArrayList<GPUPart> GPUs = new ArrayList<GPUPart>();
    private ArrayList<PSUPart> PSUs = new ArrayList<PSUPart>();
    private ArrayList<MOBOPart> MOBOs = new ArrayList<MOBOPart>();

    public PartDatabase() {
        makeGPUs();
        makeCases();
        makeCPUs();
        makePSUs();
    }

    public void makeGPUs(){
        GPUPart GPU1 = new GPUPart("RTX 3060 12GB", "NVIDIA", 3060, new float[]{1, 2, 3},
                500, 200,1700,300,4,12,"gddr6","silver");
        components.add(GPU1);
        GPUs.add(GPU1);

        GPUPart GPU2 = new GPUPart("RTX 3070", "NVIDIA", 3070, new float[]{4, 5, 6},
                600, 300,1700,300,4,8,"gddr6","silver");
        components.add(GPU2);
        GPUs.add(GPU2);

        GPUPart GPU3 = new GPUPart("RTX 2080 TI", "NVIDIA", 3080, new float[]{7, 8, 9},
                700, 500,1700,300,4,11,"gddr6","silver");
        components.add(GPU3);
        GPUs.add(GPU3);

        GPUPart GPU4 = new GPUPart("RTX 3090", "NVIDIA", 3090, new float[]{10, 11, 12},
                800, 600,1700,300,4,24,"gddr6","silver");
        components.add(GPU4);
        GPUs.add(GPU4);
    }

    public void makeCases(){
        CasePart case1 = new CasePart("torrent nano", "fractal", 1,new float[]{20, 20, 20},
                100);
        components.add(case1);
        Case.add(case1);

        CasePart case2 = new CasePart("Ranger-R4 ATX", "DIYPC", 2,new float[]{1, 30, 3},
                10000);
        components.add(case2);
        Case.add(case2);
    }

    public void makeCPUs(){
        CPUPart CPU1 = new CPUPart("i5 10600k","intel", 3, new float[]{1, 1, 1}, 280, 125, 6, 12,4.8, 12, "lga1200", 16, 3);
        components.add(CPU1);
        CPUs.add(CPU1);

        CPUPart CPU2 = new CPUPart("r7 5800x", "amd", 4, new float[]{1, 1, 1}, 200, 105, 8, 16,4.7, 32, "am4", 20, 4);
        components.add(CPU2);
        CPUs.add(CPU2);

        CPUPart CPU3 = new CPUPart("r5 1600x","amd", 5, new float[]{1, 1, 1}, 200, 95, 6, 12,4.0, 16, "am4", 24, 3);
        components.add(CPU3);
        CPUs.add(CPU3);
    }

    public void makePSUs(){
        PSUPart PSU1 = new PSUPart("RM850x", "corsair", 6, new float[]{5, 5, 5}, 120, 850);
        components.add(PSU1);
        PSUs.add(PSU1);

        PSUPart PSU2 = new PSUPart("smart700", "thermaltake", 7, new float[]{6, 6, 6}, 120, 850);
        components.add(PSU2);
        PSUs.add(PSU2);
    }

    public void makeMOBOs(){
        MOBOPart MOBO1 = new MOBOPart("b550", "aurous", 8, new float[]{1, 1, 1}, 120,"atx", "am4", 4, "ddr4", "black", 4, 2, 2, 4, 1, 4);
        components.add(MOBO1);
        MOBOs.add(MOBO1);

        MOBOPart MOBO2 = new MOBOPart("z490", "asus", 9, new float[]{1, 1, 1}, 120,"atx", "lga1200", 4, "ddr4", "black", 4, 2, 2, 4, 1, 4);
        components.add(MOBO2);
        MOBOs.add(MOBO2);
    }

    public ArrayList<PCComponent> getComponents() {
        return components;
    }

    public ArrayList<CPUPart> getCPUs() {
        return CPUs;
    }

    public ArrayList<GPUPart> getGPUs() {
        return GPUs;
    }

    public ArrayList<CasePart> getCase() {
        return Case;
    }

    public ArrayList<PSUPart> getPSUs() {
        return PSUs;
    }

    public ArrayList<MOBOPart> getMOBOs() {
        return MOBOs;
    }

    //    public populateParts() {
//
//    }
//
//    public ArrayList<GPUPart> populateGPU() throws IOException{
//        BufferedReader reader = new BufferedReader(new FileReader("data/GPU.txt"));
//        String readLine;
//        while ((readLine = reader.readLine()) != null) {
//            while
//        }
//        reader.close();
//    }
//
//    public ArrayList<CPUPart> populateCPU() throws IOException{
//        BufferedReader reader = new BufferedReader(new FileReader("data/CPU.txt"));
//        String readLine;
//        while ((readLine = reader.readLine()) != null) {
//            System.out.println(readLine);
//        }
//        reader.close();
//    }
//
//    public ArrayList<CasePart> populateCase() throws IOException{
//        BufferedReader reader = new BufferedReader(new FileReader("data/Case.txt"));
//        String readLine;
//        while ((readLine = reader.readLine()) != null) {
//            System.out.println(readLine);
//        }
//        reader.close();
//    }
//
//    public ArrayList<MOBOPart> populateMOBO() throws IOException{
//        BufferedReader reader = new BufferedReader(new FileReader("data/MOBO.txt"));
//        String readLine;
//        while ((readLine = reader.readLine()) != null) {
//            System.out.println(readLine);
//        }
//        reader.close();
//    }
//
//    public ArrayList<PSUPart> populatePSU() throws IOException{
//        BufferedReader reader = new BufferedReader(new FileReader("data/PSU.txt"));
//        String readLine;
//        while ((readLine = reader.readLine()) != null) {
//            System.out.println(readLine);
//        }
//        reader.close();
//    }
}
