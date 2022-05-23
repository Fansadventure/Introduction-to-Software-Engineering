package de.tum.in.ase.eist;

import java.net.URL;
import java.util.Set;

public class SchoolProxy implements ConnectionInterface {
    private Set<String> blacklistedHosts;
    private URL redirectPage;
    private Set<Integer> teacherIDs;
    private boolean authorized;
    private NetworkConnection networkConnection;

    public SchoolProxy(Set<String> blackList, URL redirectPage, Set<Integer> teacherIDs) {
        this.blacklistedHosts = blackList;
        this.redirectPage = redirectPage;
        this.teacherIDs = teacherIDs;
        this.authorized = false;
        this.networkConnection = new NetworkConnection();
    }
    // TODO: Implement the SchoolProxy

    @Override
    public void connect(URL url) {
        String host = url.getHost();
        // teachers can access any URL:
        if (authorized) {
            networkConnection.connect(url);
        } else { // students can only access allowed URL:
            boolean allowed = true;
            for (String p: blacklistedHosts) {
                if (host.equals(p)) {
                    allowed = false;
                    System.out.println("The requested URL " + url + " is rejected.");
                    this.connect(redirectPage);
                    break;
                }
            }
            if (allowed) {
                networkConnection.connect(url);
            }
        }
    }

    @Override
    public void disconnect() {
        networkConnection.disconnect();
    }

    @Override
    public boolean isConnected() {
        return networkConnection.isConnected();
    }

    public void login(int teacherID) {
        for (Integer i : teacherIDs) {
            if (teacherID == i) {
                authorized = true;
                break;
            }
        }
        if (!authorized) {
            this.connect(redirectPage);
            System.out.println("Authentification failed, redirected to: " + redirectPage);
        }

    }

    public void logout() {
        authorized = false;
        networkConnection.disconnect();
    }
}
