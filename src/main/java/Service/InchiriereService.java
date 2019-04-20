package Service;

import Domain.Inchiriere;
import Repository.IRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InchiriereService {
    private IRepository<Inchiriere> repository;

    private Stack<UndoRedoOperation<Inchiriere>> undoableOperations = new Stack<>();
    private Stack<UndoRedoOperation<Inchiriere>> redoableeOperations = new Stack<>();

    public InchiriereService(IRepository<Inchiriere> repository) {
        this.repository = repository;
    }

    /**
     * Adds a card client with the given fields.
     * @param id the id - must be unique.
     * @param idMasina the id masina.
     * @param numberOfDays the numberOfDays.
     * @param kilometriParcursi the kilometriParcursi
     */
    public void insert(String id, String idMasina, int numberOfDays, double kilometriParcursi) {
        Inchiriere card = new Inchiriere(id, idMasina, numberOfDays, kilometriParcursi);
        List<Inchiriere> all = new ArrayList<>(repository.getAll());

        repository.insert(card);
        undoableOperations.add(new AddOperation<>(repository, card));
        redoableeOperations.clear();
    }


    /**
     * Searches clients whose field contain a given text.
     * @return a list of clients whose fields contain text.
     */

    /**public List<Inchiriere> fullTextSearch(String text) {
        List<Inchiriere> found = new ArrayList<>();
        for (Inchiriere c : repository.getAll()) {

            if ((c.getId().contains(text) || c.getLastName().contains(text) ||
                    c.getFirstName().contains(text) || c.getCNP().contains(text) ||
                    c.getDateOfBirth().toString().contains(text) || c.getDateOfRegistration().toString().contains(text)) &&
                    !found.contains(c)) {
                found.add(c);
            }
        }
        return found;
    }
**/
    public void undo() {
        if (!undoableOperations.empty()) {
            UndoRedoOperation<Inchiriere> lastOperation = undoableOperations.pop();
            lastOperation.doUndo();
            redoableeOperations.add(lastOperation);
        }
    }

    public void redo() {
        if (!redoableeOperations.empty()) {
            UndoRedoOperation<Inchiriere> lastOperation = redoableeOperations.pop();
            lastOperation.doRedo();
            undoableOperations.add(lastOperation);
        }
    }

    /**
     * removes inchiriere selection.
     * @param id the id of the client card to removes
     */
    public void remove(String id) {
        Inchiriere card = repository.getById(id);
        repository.remove(id);
        undoableOperations.add(new DeleteTransaction<>(repository, card));
        redoableeOperations.clear();
    }


    /**
     * Gets a list of all client cards.
     * @return an ArrayList with all client cards.
     **/
    public List<Inchiriere> getAll() {
        return repository.getAll();
    }

    public IRepository<Inchiriere> getRepository() {
        return repository;
    }
}


