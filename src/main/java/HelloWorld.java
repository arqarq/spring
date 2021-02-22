class HelloWorld {
    private String name = "Arkadiusz";

    public void setName(String stringName) {
        this.name = stringName;
    }

    void printHello() {
        System.out.println("Hello " + name + '!');
    }
}
