package com.usa.misiontic.ciclo3.service;


import com.usa.misiontic.ciclo3.entities.Category;
import com.usa.misiontic.ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c){
        if (c.getId()==null){
            return categoryRepository.save(c);
        }else{
            Optional<Category>caux=categoryRepository.getCategory(c.getId());
            if (caux.isEmpty()){
                return categoryRepository.save(c);
            }else{
                return c;
            }
        }
    }
    public Category update(Category cat){
        if(cat.getId()!=null){
            Optional<Category> old= categoryRepository.getCategory(cat.getId());
            if(old.isPresent()){
                Category k=old.get();

                if(cat.getDescription()!=null){
                    k.setDescription(cat.getDescription());
                }
                if(cat.getName()!=null){
                    k.setName(cat.getName());
                }

                return categoryRepository.save(k);
            }
        }
        return cat;
    }

    public boolean delete(int id) {
        Optional<Category> cOp = categoryRepository.getCategory(id);
        if (cOp.isPresent()) {
            categoryRepository.delete(cOp.get());
            return true;
        }
        return false;
    }
}
