public class GPUPart extends PCPoweredComponent {
    private float CUDAcores;
    private float RTcores;
    private float PCIE_ver;
    private float memory;
    private String memory_type;
    private String color;

    public GPUPart(String name, String manufacturer, int modelNumber, float[] dimensions, float price, int wattage,
                   float CUDAcores, float RTcores, float PCIE_ver, float memory, String memory_type, String color) {
        super(name, manufacturer, modelNumber, dimensions, price, wattage);
        this.CUDAcores = CUDAcores;
        this.RTcores = RTcores;
        this.PCIE_ver = PCIE_ver;
        this.memory = memory;
        this.memory_type = memory_type;
        this.color = color;
    }

    public float getMemory() {
        return memory;
    }

    public float getCUDAcores() {
        return CUDAcores;
    }

    public float getPCIE_ver() {
        return PCIE_ver;
    }

    public float getRTcores() {
        return RTcores;
    }

    public String getColor() {
        return color;
    }

    public String getMemory_type() {
        return memory_type;
    }

    /*@Override
    public String toString() {
        return "name=" + name +
                "CUDAcores=" + CUDAcores +
                ", RTcores=" + RTcores +
                ", PCIE_ver=" + PCIE_ver +
                ", memory=" + memory +
                ", memory_type='" + memory_type + '\'' +
                ", wattage=" + wattage +
                ", color='" + color + '\'' +
                '}';
    }*/
}
