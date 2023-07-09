package com.keremturak.utility;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class ServiceManager<T,ID> implements IService<T,ID>{
    private final JpaRepository<T,ID> repository;
    public ServiceManager(JpaRepository<T,ID> repository){
        this.repository = repository;
    }
    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> entityList) {
        return repository.saveAll(entityList);
    }


    /**
     * DİKKAT!!!!!
     * Güncelleme ve Kaydet işlemleri repository de save(T entity) şeklinde tanımlıdır.
     * peki güncellemeyi kayıt etmeden nasıl ayırt ediyoruz?
     * bir ORM aracı kayıtları varlıklarla eşleştirirken ID yi kullanır. yani varlık-tablo ilişkisini ID ile kurar.
     * bu nedenle eğer kayıt ettiğiniz entity içinde id bilgisi null ise save methosdu kayıt işlemi yapar.
     * eğer id bilgisi dolu ise güncelleme işlemi yapar.
     *
     * @param entity
     */
    @Override
    public T update(T entity) {
        return repository.save(entity);
    }
    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }
    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }
    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
    @Override
    public List<T> findAllByIds(List<ID> ids) {
        return repository.findAllById(ids);
    }
}
