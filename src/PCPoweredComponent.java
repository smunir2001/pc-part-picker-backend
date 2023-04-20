public class PCPoweredComponent extends PCComponent{
    protected int wattage;

    public PCPoweredComponent(String name, String manufacturer, int modelNumber, float[] dimensions, float price, int wattage) {
        super(name, manufacturer, modelNumber, dimensions, price);
        this.wattage = wattage;
    }

    public int getWattage() {
        return this.wattage;
    }
}
