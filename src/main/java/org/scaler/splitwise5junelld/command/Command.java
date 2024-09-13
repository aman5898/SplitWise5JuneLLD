package org.scaler.splitwise5junelld.command;

public interface Command {
    boolean matches(String cmd);
    void execute(String cmd);
}
