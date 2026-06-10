package com.fif.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application") // Hibernate akan otomatis membuat tabel 'application' di database
public class Application implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "app-generator")
    @GenericGenerator(name = "app-generator",
            parameters = @Parameter(name = "prefix", value = "app"), // Format ID otomatis: app-xxxx
            strategy = "com.fif.util.MyGenerator")
    private String id;

    @Column(name = "nama_lengkap", nullable = false)
    private String namaLengkap;

    @Column(name = "no_telp")
    private String noTelp;

    @Column(name = "penghasilan")
    private Float penghasilan;

    @Column(name = "total_cicilan")
    private Float totalCicilan;

    @Column(name = "tujuan_pinjaman")
    private String tujuanPinjaman;

    @Column(name = "riwayat_pembayaran")
    private String riwayatPembayaran;

    // Constructor Kosong (Wajib untuk Hibernate)
    public Application() {
    }

    // Constructor Lengkap
    public Application(String namaLengkap, String noTelp, Float penghasilan, Float totalCicilan, String tujuanPinjaman, String riwayatPembayaran) {
        this.namaLengkap = namaLengkap;
        this.noTelp = noTelp;
        this.penghasilan = penghasilan;
        this.totalCicilan = totalCicilan;
        this.tujuanPinjaman = tujuanPinjaman;
        this.riwayatPembayaran = riwayatPembayaran;
    }

    // --- Getter dan Setter ---

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNamaLengkap() { return namaLengkap; }
    public void setNamaLengkap(String namaLengkap) { this.namaLengkap = namaLengkap; }

    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }

    public Float getPenghasilan() { return penghasilan; }
    public void setPenghasilan(Float penghasilan) { this.penghasilan = penghasilan; }

    public Float getTotalCicilan() { return totalCicilan; }
    public void setTotalCicilan(Float totalCicilan) { this.totalCicilan = totalCicilan; }

    public String getTujuanPinjaman() { return tujuanPinjaman; }
    public void setTujuanPinjaman(String tujuanPinjaman) { this.tujuanPinjaman = tujuanPinjaman; }

    public String getRiwayatPembayaran() { return riwayatPembayaran; }
    public void setRiwayatPembayaran(String riwayatPembayaran) { this.riwayatPembayaran = riwayatPembayaran; }
}