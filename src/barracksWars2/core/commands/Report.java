package barracksWars2.core.commands;

import barracksWars2.annotations.Inject;
import barracksWars2.interfaces.Repository;

public class Report extends Command {

    @Inject
    private Repository repository;

    public Report(String[] data) {

        super(data);
    }

    @Override
    public String execute() {

        return this.repository.getStatistics();
    }
}