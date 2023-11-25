package br.com.uri.SpringDemo.repositories;

import br.com.uri.SpringDemo.entities.HelloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface HelloRepository extends JpaRepository<HelloEntity, Long> {

    Optional<HelloEntity> findByMessage(String message);

}
