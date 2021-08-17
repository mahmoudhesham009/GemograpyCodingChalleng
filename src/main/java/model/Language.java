package model;

import java.util.ArrayList;
import java.util.Objects;

public class Language {
    private String name;
    private int numOfRepos;
    private ArrayList<String> repos;

    public Language(String name, int numOfRepos) {
        this.name = name;
        this.numOfRepos = numOfRepos;
        repos=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfRepos() {
        return numOfRepos;
    }

    public void setNumOfRepos(int numOfRepos) {
        this.numOfRepos = numOfRepos;
    }

    public ArrayList<String> getRepos() {
        return repos;
    }

    public void setRepos(ArrayList<String> repos) {
        this.repos = repos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(name, language.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
