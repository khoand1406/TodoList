package com.project.Service;

import java.util.List;

import com.project.DAO.iInterface.SubTodoInterface;
import com.project.Model.SubTodo;

public class SubTodoImpl implements SubTodoService {

    private SubTodoInterface subTodoRepo;

    @Override
    public SubTodo get(Long id) {
        return subTodoRepo.get(id);
    }

    @Override
    public List<SubTodo> getByTodo(Long id) {
        return subTodoRepo.getByTodo(id);
    }

    @Override
    public void addSubTodo(SubTodo sub) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addSubTodo'");
    }

    @Override
    public void updateSub(SubTodo sub) {
        subTodoRepo.save(sub);
    }

    @Override
    public void deleteSub(SubTodo sub) {
        subTodoRepo.delete(sub);
    }

}
