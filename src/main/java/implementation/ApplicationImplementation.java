package implementation;

import model.Application;
import services.ApplicationService;

import java.util.ArrayList;
import java.util.List;

public class ApplicationImplementation implements ApplicationService {

    // 1. KUNCI UTAMA: Wajib pakai 'static' agar list ini hanya ada SATU di memori server
    private static List<Application> applicationList = new ArrayList<>();

    // 2. KUNCI KEDUA: Menggunakan static block, BUKAN constructor lagi.
    // Ini hanya akan berjalan 1x saat aplikasi pertama kali dijalankan.
    static {
        applicationList.add(
                new Application(
                        "Tony Stark",
                        "081234567890",
                        25000000f,
                        3000000f,
                        "Usaha",
                        "Baik - Tidak Pernah Telat"
                )
        );

        applicationList.add(
                new Application(
                        "Peter Parker",
                        "081234567891",
                        8000000f,
                        2500000f,
                        "Usaha",
                        "Baik - Tidak Pernah Telat"
                )
        );

        applicationList.add(
                new Application(
                        "Bruce Wayne",
                        "081234567892",
                        50000000f,
                        5000000f,
                        "Usaha",
                        "Baik - Tidak Pernah Telat"
                )
        );

        applicationList.add(
                new Application(
                        "Clark Kent",
                        "081234567893",
                        12000000f,
                        7000000f,
                        "Usaha",
                        "Baik - Tidak Pernah Telat"
                )
        );
    }

    @Override
    public List<Application> findAll() {
        return applicationList;
    }

    @Override
    public List<Application> search(String keyword) {
        List<Application> hasilPencarian = new ArrayList<>();

        if (keyword == null || keyword.trim().isEmpty()) {
            return applicationList;
        }

        String lowerCaseKeyword = keyword.toLowerCase().trim();

        for (Application app : applicationList) {
            boolean cocokNama = app.getNamaLengkap() != null && app.getNamaLengkap().toLowerCase().contains(lowerCaseKeyword);
            boolean cocokTelp = app.getNoTelp() != null && app.getNoTelp().contains(lowerCaseKeyword);

            if (cocokNama || cocokTelp) {
                hasilPencarian.add(app);
            }
        }

        return hasilPencarian;
    }

    @Override
    public void add(Application application) {
        applicationList.add(application); // Sekarang data masuk ke list static yang aman dari reset
    }
}