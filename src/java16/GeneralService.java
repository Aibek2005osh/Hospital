package java16;


public interface GeneralService<Type> {

    String save(Long id ,Type type);


    String updateById(Long id, Type type);


    void deleteById(Long id);




}
