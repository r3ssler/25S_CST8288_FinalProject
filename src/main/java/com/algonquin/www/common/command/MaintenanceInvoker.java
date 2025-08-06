package com.algonquin.www.common.command;

public class MaintenanceInvoker {
    private final MaintenanceCommand command;
   
    public MaintenanceInvoker(MaintenanceCommand command) {
        this.command = command;
    }
    
    public void execute() {
        command.execute();
    }
}
