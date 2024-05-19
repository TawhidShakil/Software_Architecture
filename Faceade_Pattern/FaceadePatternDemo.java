package Faceade_Pattern;

// product

interface Device{
    void identify();
}

// concreate products

class Lights implements Device{
    public void identify(){
        System.out.println("This is a light!");
    }
}

class Thermostates implements Device{
    public void identify(){
        System.out.println(("This is a Thermostates!"));
    }
}


class Camera implements Device{
    public void identify(){
        System.out.println("This is a Camera!");
    }
}

// creator

class DeviceManager{
    private Device light;
    private Device thermostate;
    private Device camera;

    public DeviceManager(){
        light = new Lights();
        thermostate = new Thermostates();
        camera = new Camera();
    }

    // method

    public void createLight(){
        light.identify();
    }

    public void createThermostates(){
        thermostate.identify();
    }

    public void createCamera(){
        camera.identify();
    }
}

// concreate creator

class FaceadePatternDemo{
    public static void main(String[] args) {
        DeviceManager deviceManager = new DeviceManager();
        deviceManager.createLight();
        deviceManager.createThermostates();
        deviceManager.createCamera();
    }
}