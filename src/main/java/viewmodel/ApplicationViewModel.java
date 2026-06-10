package viewmodel;

import com.fif.entity.Application; // Diubah ke Entity baru
import com.fif.services.impl.DatabaseAppRepository; // Menggunakan Repository Utama Langkah 3
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ApplicationViewModel {

    private String currentPage = "form/form.zul";
    private String keyword;
    private List<Application> applicationList = new ListModelList<Application>();

    // Properti untuk menampung inputan form dari form.zul
    private Application currentApplication = new Application();

    // KUNCI DB: Inject Bean Repository database yang kita buat di Langkah 4 kemarin
    @WireVariable("DatabaseApplicationRepository")
    private DatabaseAppRepository databaseAppRepository;

    @Init
    public void init() {
        // Mengambil seluruh data pengajuan nasabah langsung dari database
        applicationList.addAll(databaseAppRepository.findAll());
    }

    // --- Command Fitur Pencarian Database ---
    @Command
    public void search() {
        applicationList.clear();
        List<Application> allApplications = databaseAppRepository.findAll();

        if (keyword == null || keyword.trim().isEmpty()) {
            applicationList.addAll(allApplications);
            return;
        }

        String lowerCaseKeyword = keyword.toLowerCase().trim();
        for (Application app : allApplications) {
            boolean cocokNama = app.getNamaLengkap() != null && app.getNamaLengkap().toLowerCase().contains(lowerCaseKeyword);
            boolean cocokTelp = app.getNoTelp() != null && app.getNoTelp().contains(lowerCaseKeyword);

            if (cocokNama || cocokTelp) {
                applicationList.add(app);
            }
        }
    }

    // --- Command Form & Navigasi Redirect ---
    @Command
    public void submitForm() {
        try {
            // 1. Simpan data nasabah baru dari form secara nyata ke DATABASE!
            databaseAppRepository.save(currentApplication);
            System.out.println("Data Berhasil ditambahkan ke Database");

            // 2. Reset isi form agar bersih kembali
            currentApplication = new Application();

            // 3. Redirect ke halaman tabel informasi customer (Step 2)
            Executions.sendRedirect("customer_information.zul");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Command
    public void kembaliKeStepSatu() {
        Executions.sendRedirect("form.zul");
    }

    // --- Getter & Setter ---

    public Application getCurrentApplication() {
        return currentApplication;
    }

    public void setCurrentApplication(Application currentApplication) {
        this.currentApplication = currentApplication;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }
}