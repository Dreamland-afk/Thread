package org.dreamquest.designpatterns.memento;

public class Thermostat {
    private int temperature;
    private int humidity;
    private boolean ecoMode;
    private String connectionPassword;

    public Thermostat(int temperature, int humidity, boolean ecoMode, String connectionPassword) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.ecoMode = ecoMode;
        this.connectionPassword = connectionPassword;

    }

    public String toString() {
        return "Thermostat{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", ecoMode=" + ecoMode +
                ", connectionPassword='" + connectionPassword + '\'' +
                '}';
    }

    public Memento saveState() {
        return new Memento(temperature, humidity, ecoMode,connectionPassword);
    }

    public void restoreState(Memento memento) {
        this.temperature = memento.temperature;
        this.humidity = memento.humidity;
        this.ecoMode = memento.ecoMode;
        this.connectionPassword = memento.connectionPassword;
        System.out.println(this.toString());
    }

    public class Memento {
        private final int temperature;
        private final int humidity;
        private final boolean ecoMode;
        private final String connectionPassword;

        private Memento(int temperature, int humidity, boolean ecoMode,String connectionPassword) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.ecoMode = ecoMode;
            this.connectionPassword = connectionPassword;
        }
    }
}
