public class PCComponent {
    private String name;
    private String manufacturer;
    private int modelNumber;
    private float[] dimensions;
    private float price;

    public PCComponent(String name, String manufacturer, int modelNumber, float[] dimensions, float price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.modelNumber = modelNumber;
        this.dimensions = dimensions;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelNumber() {
        String output = Integer.toString(this.modelNumber);
        return output;
    }

    public float[] getDimensions() {
        return dimensions;
    }

    public float getPrice() {
        return price;
    }
}
