package com.favshare.entity;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // javax.persistence�� org.hibernate.annotations�� javax.persistence��� ����
@Table(name = "user") // ���̺� �̸�
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class userEntity {
	@Id // PK
	private String email;
	private String name; // ���̺��� ������� ��ü�� �������� �����ϸ� ���� �������� �ʾƵ� ��
	@Column(name = "created_at") // ���̺��� created_at������ ��ü�� createdAt������ �����ϰڴٴ� �ǹ�
	private LocalDateTime createdAt;
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	// �Һ��� ���������� �۵��ϸ� ���־� �� �ڵ�
	public userEntity(String email, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.email = email;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public userEntity() {
		super();
	}
	
}
