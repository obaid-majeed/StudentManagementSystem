import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public void saveStudent(Student student) {
        repository.save(student);
    }

    public void deleteStudent(int id) {
        repository.deleteById(id);
    }

    public Optional<Student> getStudentById(int id) {
        return repository.findById(id);
    }
}
