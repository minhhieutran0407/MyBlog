package hust.hieutm.model;

public class Overview {
    private int id;
    private int worldsComplete;
    private int experience;
    private int totalClients;
    private int awardWon;

    public Overview(){
    }

    public Overview(int worldsComplete, int experience, int totalClients, int awardWon) {
        this.worldsComplete = worldsComplete;
        this.experience = experience;
        this.totalClients = totalClients;
        this.awardWon = awardWon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorldsComplete() {
        return worldsComplete;
    }

    public void setWorldsComplete(int worldsComplete) {
        this.worldsComplete = worldsComplete;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getTotalClients() {
        return totalClients;
    }

    public void setTotalClients(int totalClients) {
        this.totalClients = totalClients;
    }

    public int getAwardWon() {
        return awardWon;
    }

    public void setAwardWon(int awardWon) {
        this.awardWon = awardWon;
    }
}
