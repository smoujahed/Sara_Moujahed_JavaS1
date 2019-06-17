public class polymorphism {
    public static void main(String[] args) {
        Developer developer = new Developer();
        TeamLead teamLead = new TeamLead();
        Architect architect= new Architect();

        Developer developer1 = new TeamLead();
        Developer developer2 = new Architect();

        TeamLead teamLead1;
        teamLead1=(TeamLead)developer1; // all team leads are developers, but not all developers are team leads
        teamLead1.planSprint();

        teamLead1.planSprint();
        developer.checkInCode();
        developer.estimateStoryPoints();

        teamLead.assignWork(developer);
        teamLead.estimateStoryPoints();
        teamLead.planSprint();


        architect.createTechRoadmap();
        architect.evaluateVendor();
        architect.assignWork(developer);
        architect.estimateStoryPoints();
        architect.planSprint();
        architect.checkInCode();

    }

}
