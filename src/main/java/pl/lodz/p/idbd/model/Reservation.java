package pl.lodz.p.idbd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATIONS")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_id_seq")
    @SequenceGenerator(name="reservation_id_seq", sequenceName="reservation_id_seq", allocationSize=1)
	@Column(name="ID")
	private Long id;
	
	@Column(name="BOOK_ID")
	private Long bookId;
	
	@Column(name="CLIENT_ID")
	private Long clientId;
	
	@Column(name="IS_CANCELED")
	private boolean isCanceled;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBook() {
		return bookId;
	}

	public void setBook(Long book) {
		this.bookId = book;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public boolean isCanceled() {
		return isCanceled;
	}

	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}
	
}
