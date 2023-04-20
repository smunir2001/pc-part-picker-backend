public class PSUPart extends PCComponent {
    private int wattage;

    public PSUPart(String name, String manufacturer, int modelNumber, float[] dimensions, float price, int wattage) {
        super(name, manufacturer, modelNumber, dimensions, price);
        this.wattage = wattage;
    }

    public int getWattage() {
        return this.wattage;
    }
}
