package model;

public class Application {
    String namaLengkap;
    String noTelp;
    Float penghasilan;
    Float totalCicilan;
    String tujuanPinjaman;
    String riwayatPembayaran;

    public Application() {
    }

    public Application(String namaLengkap, String noTelp, Float penghasilan, Float totalCicilan, String tujuanPinjaman, String riwayatPembayaran) {
        this.namaLengkap = namaLengkap;
        this.noTelp = noTelp;
        this.penghasilan = penghasilan;
        this.totalCicilan = totalCicilan;
        this.tujuanPinjaman = tujuanPinjaman;
        this.riwayatPembayaran = riwayatPembayaran;
    }


    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public Float getPenghasilan() {
        return penghasilan;
    }

    public void setPenghasilan(Float penghasilan) {
        this.penghasilan = penghasilan;
    }

    public Float getTotalCicilan() {
        return totalCicilan;
    }

    public void setTotalCicilan(Float totalCicilan) {
        this.totalCicilan = totalCicilan;
    }

    public String getTujuanPinjaman() {
        return tujuanPinjaman;
    }

    public void setTujuanPinjaman(String tujuanPinjaman) {
        this.tujuanPinjaman = tujuanPinjaman;
    }

    public String getRiwayatPembayaran() {
        return riwayatPembayaran;
    }

    public void setRiwayatPembayaran(String riwayatPembayaran) {
        this.riwayatPembayaran = riwayatPembayaran;
    }
}