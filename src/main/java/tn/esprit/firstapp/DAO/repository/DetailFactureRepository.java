package tn.esprit.firstapp.DAO.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.firstapp.DAO.entity.DetailFacture;

import java.util.List;


@Repository
public interface DetailFactureRepository extends CrudRepository<DetailFacture, Long> {
    public List<DetailFacture> findDetailFacturesByFactureIdFacture(long idFacture);
    public void deleteDetailFactureByFactureIdFacture(long idFacture);

}
