package com.mahmoudh.gemography_coding_challenge.service;

import com.mahmoudh.gemography_coding_challenge.model.Data;
import com.mahmoudh.gemography_coding_challenge.model.Item;
import com.mahmoudh.gemography_coding_challenge.model.Language;
import com.mahmoudh.gemography_coding_challenge.repository.HttpFetchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class RepoService {
    private HttpFetchRepository httpFetchRepository;

    @Autowired
    public void setHttpFetchRepository(HttpFetchRepository httpFetchRepository) {
        this.httpFetchRepository = httpFetchRepository;
    }

    public List<Language> getResult() throws IOException {
        Data data=httpFetchRepository.getResponce();
        ArrayList<Language> result=new ArrayList<>();
        for (Item i:data.getItems()) {
            if (i.getLanguage()==null)
                continue;
            Language lang=new Language(i.getLanguage(),1);
            if(!result.contains(lang)){
                lang.getRepos().add(i.getName());
                result.add(lang);
            }else{
                lang=result.get(result.indexOf(lang));
                lang.setNumOfRepos(lang.getNumOfRepos()+1);
                lang.getRepos().add(i.getName());
            }
        }
        Collections.sort(result, new Comparator<Language>() {
            @Override
            public int compare(Language o1, Language o2) {
                if (o1.getNumOfRepos() < o2.getNumOfRepos())
                {
                    return 1;
                }
                else if (o1.getNumOfRepos() > o2.getNumOfRepos())
                {
                    return -1;
                }
                return 0;
            }
        });
        return result;
    }






}
