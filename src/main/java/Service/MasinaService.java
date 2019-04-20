package Service;

import Domain.Masina;
import Repository.IRepository;

import java.util.*;

public class MasinaService {

    private IRepository<Masina> masinaRepository;


    private Stack<UndoRedoOperation<Masina>> undoableOperations = new Stack<>();
    private Stack<UndoRedoOperation<Masina>> redoableeOperations = new Stack<>();

    /**
     * Contructs a service.
     * @param masinaRepository the backing repository.
     *
     */
    public MasinaService(IRepository<Masina> masinaRepository) {
        this.masinaRepository = masinaRepository;

    }

    /**
     * adds a masina with the given fields.
     *
     * @param id the id - must be unique.
     * @param model the model.
     * @param kilometrajAchiz the kilometraj achizitie.
     * @param pretInchiriereZi the price greater then 0.
     */
    public void insert(String id, String model, double kilometrajAchiz, double pretInchiriereZi) {
        Masina masina = new Masina(id, model, kilometrajAchiz, pretInchiriereZi);
        masinaRepository.insert(masina);
        undoableOperations.add(new AddOperation<>(masinaRepository, masina));
        redoableeOperations.clear();
    }

    /**
     * updates a masina with the given fields.
     *
     * @param id the id - must be unique.
     * @param model the model.
     * @param kilometrajAchiz the kilometraj achizitie.
     * @param pretInchiriereZi the price greater then 0.
     */
    public void update(String id, String model, double kilometrajAchiz, double pretInchiriereZi) {
        Masina actualMasina = masinaRepository.getById(id);
        Masina masinaUpdate = new Masina(id, model, kilometrajAchiz, pretInchiriereZi);
        masinaRepository.update(masinaUpdate);

        undoableOperations.add(new UpdateOperation(masinaRepository, masinaUpdate, actualMasina));

        redoableeOperations.clear();
    }

    /**
     * removes a medicine - selection.
     *
     * @param id the id on the medicine to remove
     */
   /** public void remove(String id) {
        Masina masina = medicineRepository.getById(id);
        medicineRepository.remove(id);

        undoableOperations.add(new DeleteTransaction<>(medicineRepository, masina));
        redoableeOperations.clear();
    }
**/


    /**
     * Gets a list of all medicines
     *
     * @return a list with all medicines
     */
    public List<Masina> getAll() {
        return masinaRepository.getAll();
    }


    /**
     * search a text to find
     *
     * @return a list with all medicines where the text was found
     */
   /** public List<Masina> fullTextSearch(String text) {
        List<Masina> found = new ArrayList<>();
        for (Masina med : medicineRepository.getAll()) {
            if ((med.getId().contains(text) || med.getName().contains(text) || med.getProducer().contains(text) ||
                    Double.toString(med.getPrice()).contains(text) ||
                    Boolean.toString(med.isRecipe()).contains(text)) && !found.contains(med)) {
                found.add(med);
            }
        }
        return found;
    }
**/


    /** Makes operation undo of the last operation.
     *
     */
    public void undo() {
        if (!undoableOperations.empty()) {
            UndoRedoOperation<Masina> lastOperation = undoableOperations.pop();
            lastOperation.doUndo();
            redoableeOperations.add(lastOperation);
        }
    }
    /**
     *  Makes operation redo of the last operation.
     */
    public void redo() {
        if (!redoableeOperations.empty()) {
            UndoRedoOperation<Masina> lastOperation = redoableeOperations.pop();
            lastOperation.doRedo();
            undoableOperations.add(lastOperation);
        }
    }

}