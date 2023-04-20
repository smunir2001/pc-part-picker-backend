import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PCBuild {
    private ArrayList<PCComponent> pcBuildComponentList;
    private PCComponent tempPartHolder;
    private PartDatabase partDatabase;
    private CPUPart CPU;
    private GPUPart GPU;
    private PSUPart PSU;
    private MOBOPart MOBO;
    private CasePart Case;
    private int totalWattage;
    private User owner;

    public PCBuild(User owner){
        this.owner = owner;
    }

    public ArrayList<PCComponent> selectCPU() {
        if(CPU != null) {
            tempPartHolder = CPU;
            CPU = null;
        }
        updateWattage();
        ArrayList<PCComponent> filteredList = new ArrayList<>();
        ArrayList<CPUPart> cpuParts = partDatabase.getCPUs();
        for(int i = 0; i < cpuParts.size(); i++) {
            if(sizeCheck(cpuParts.get(i)) && wattageCheck(cpuParts.get(i))) {
                filteredList.add(cpuParts.get(i));
            }
        }
        return filteredList;
    }

    public ArrayList<PCComponent> selectGPU() {
        if(GPU != null) {
            tempPartHolder = GPU;
            GPU = null;
        }
        updateWattage();
        ArrayList<PCComponent> filteredList = new ArrayList<>();
        ArrayList<GPUPart> gpuParts = partDatabase.getGPUs();
        for(int i = 0; i < gpuParts.size(); i++) {
            if(sizeCheck(gpuParts.get(i)) && wattageCheck(gpuParts.get(i))) {
                filteredList.add(gpuParts.get(i));
            }
        }
        return filteredList;
    }

    public ArrayList<PCComponent> selectMOBO() {
        if(MOBO != null) {
            tempPartHolder = MOBO;
            MOBO = null;
        }
        updateWattage();
        ArrayList<PCComponent> filteredList = new ArrayList<>();
        ArrayList<MOBOPart> moboParts = partDatabase.getMOBOs();
        for(int i = 0; i < moboParts.size(); i++) {
            if(sizeCheck(moboParts.get(i)) && wattageCheck(moboParts.get(i))) {
                filteredList.add(moboParts.get(i));
            }
        }
        return filteredList;
    }

    public ArrayList<PCComponent> selectPSU() {
        if(PSU != null) {
            tempPartHolder = PSU;
            PSU = null;
        }
        updateWattage();
        ArrayList<PCComponent> filteredList = new ArrayList<>();
        ArrayList<PSUPart> psuParts = partDatabase.getPSUs();
        for(int i = 0; i < psuParts.size(); i++) {
            if(sizeCheck(psuParts.get(i)) && PSUCheck(psuParts.get(i))) {
                filteredList.add(psuParts.get(i));
            }
        }
        return filteredList;
    }

    public ArrayList<PCComponent> selectCase() {
        if(Case != null) {
            tempPartHolder = Case;
            Case = null;
        }
        ArrayList<PCComponent> filteredList = new ArrayList<>();
        ArrayList<CasePart> caseParts = partDatabase.getCase();
        for(int i = 0; i < caseParts.size(); i++) {
            if(caseCheck(caseParts.get(i))) {
                filteredList.add(caseParts.get(i));
            }
        }
        return filteredList;
    }

    public boolean addComponent(String partType, int selection){
        ArrayList<PCComponent> filteredList = new ArrayList<>();
        switch(partType.toLowerCase()) {
            case "cpu":
                filteredList.addAll(selectCPU());
                if(filteredList.size() == 0) return false;
                if(selection == -1) {
                    CPU = (CPUPart) tempPartHolder;
                    tempPartHolder = null;
                    return false;
                }
                CPU = (CPUPart) filteredList.get(selection);
                return true;
            case "gpu":
                filteredList.addAll(selectGPU());
                if(filteredList.size() == 0) return false;
                if(selection == -1) {
                    GPU = (GPUPart) tempPartHolder;
                    tempPartHolder = null;
                    return false;
                }
                GPU = (GPUPart) filteredList.get(selection);
                return true;
            case "psu":
                filteredList.addAll(selectPSU());
                if(filteredList.size() == 0) return false;
                if(selection == -1) {
                    PSU = (PSUPart) tempPartHolder;
                    tempPartHolder = null;
                    return false;
                }
                PSU = (PSUPart) filteredList.get(selection);
            case "mobo":
                filteredList.addAll(selectMOBO());
                if(filteredList.size() == 0) return false;
                if(selection == -1) {
                    MOBO = (MOBOPart) tempPartHolder;
                    tempPartHolder = null;
                    return false;
                }
                MOBO = (MOBOPart) filteredList.get(selection);
                return true;
            case "case":
                filteredList.addAll(selectCase());
                if(filteredList.size() == 0) return false;
                if(selection == -1) {
                    Case = (CasePart) tempPartHolder;
                    tempPartHolder = null;
                    return false;
                }
                Case = (CasePart) filteredList.get(selection);
                return true;
            default:
                System.out.println("Invalid part type.");
                return false;
        }
    }

    public void removeComponent(String partType){
        switch(partType.toLowerCase()) {
            case "cpu":
                if(CPU == null) return;
                pcBuildComponentList.remove(CPU);
                CPU = null;
                updateWattage();
                return;
            case "gpu":
                if(GPU == null) return;
                pcBuildComponentList.remove(GPU);
                GPU = null;
                updateWattage();
                return;
            case "psu":
                if(PSU == null) return;
                pcBuildComponentList.remove(PSU);
                PSU = null;
                updateWattage();
                return;
            case "mobo":
                if(MOBO == null) return;
                pcBuildComponentList.remove(MOBO);
                MOBO = null;
                updateWattage();
                return;
            case "case":
                if(Case == null) return;
                pcBuildComponentList.remove(Case);
                CPU = null;
                updateWattage();
                return;
            default:
                break;
        }
    }

    private boolean sizeCheck(PCComponent part) {
        if(Case == null) return true;
        float partX = part.getDimensions()[0];
        float caseX = Case.getDimensions()[0];
        if(partX > caseX) return false;
        float partY = part.getDimensions()[1];
        float caseY = Case.getDimensions()[1];
        if(partY > caseY) return false;
        float partZ = part.getDimensions()[2];
        float caseZ = Case.getDimensions()[2];
        if(partZ > caseZ) return false;
        return true;
    }

    private boolean wattageCheck(PCComponent part) {
        if(!(part instanceof PCPoweredComponent)) return true;
        PCPoweredComponent poweredPart = (PCPoweredComponent) part;
        updateWattage();
        if(PSU.getWattage() - totalWattage - poweredPart.getWattage() < 0) {
            return false;
        }
        return true;
    }

    private void updateWattage() {
        totalWattage = 0;
        for(int i = 0; i < pcBuildComponentList.size(); i++) {
            if(pcBuildComponentList.get(i) instanceof PCPoweredComponent) {
                PCPoweredComponent poweredPart = (PCPoweredComponent) pcBuildComponentList.get(i);
                totalWattage += poweredPart.getWattage();
            }
        }
    }

    private boolean caseCheck(CasePart LocalCase) {
        if(pcBuildComponentList.size() == 0) return true;
        for(int i = 0; i < pcBuildComponentList.size(); i++) {
            PCComponent part = pcBuildComponentList.get(i);
            float partX = part.getDimensions()[0];
            float caseX = LocalCase.getDimensions()[0];
            if (partX > caseX) return false;
            float partY = part.getDimensions()[1];
            float caseY = LocalCase.getDimensions()[1];
            if (partY > caseY) return false;
            float partZ = part.getDimensions()[2];
            float caseZ = LocalCase.getDimensions()[2];
            if (partZ > caseZ) return false;
        }
        return true;
    }

    private boolean PSUCheck(PSUPart part) {
        if(pcBuildComponentList.size() == 0) return true;
        updateWattage();
        if (part.getWattage() - totalWattage < 0) return false;
        return true;
    }

    public void writeList() throws IOException {
        FileWriter fileWriter = new FileWriter("data/Builds.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        printWriter.println(owner.getUserID() + "\n" + GPU.getModelNumber() + "\n" + PSU.getModelNumber() + "\n"
                + CPU.getModelNumber() + "\n" + MOBO.getModelNumber() + "\n" + Case.getModelNumber() + "\n" + "---" + "\n");
        printWriter.close();
    }
}