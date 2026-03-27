package org.dreamquest.designpatterns.memento;
import org.dreamquest.designpatterns.memento.Thermostat.Memento;


import java.util.ArrayList;
import java.util.List;

/**
 * Caretaker class that manages the history of thermostat states using the Memento design pattern.
 * The ProfileHistory class is responsible for managing the history of thermostat states.
 * It allows saving the current state of the thermostat and restoring it to a previous state.
 * The history is maintained as a list of Memento objects, with a maximum capacity of 5 states.
 * When the history exceeds the maximum capacity, the oldest state is removed to make room for new states.
 *
 * This class interacts with the Thermostat class to save and restore the state of the thermostat using the Memento design pattern.
 * The saveState method saves the current state of the thermostat, while the restoreState method restores the thermostat to the most recent state in the history.
 * Careta
 */
public class ProfileHistory {

        private Thermostat thermostat;
        private Memento memento;
        static List<Memento> history;

        public void setThermostat(Thermostat thermostat)
        {
            this.thermostat = thermostat;
        }

        public void saveState() {
            this.memento = thermostat.saveState();
            if(history == null){
                history = new ArrayList<>();
            }
            if (history.size() == 5) {
                history.removeFirst();
            }
            history.add(memento);
        }

        public void restoreState() {
            if (memento != null) {
                thermostat.restoreState(history.getLast());
                history.removeLast();
            }
        }
}
