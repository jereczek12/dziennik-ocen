/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     04.01.2023 12:04:02                          */
/*==============================================================*/


drop index RELATIONSHIP_1_FK;

drop index KIERUNEK_PK;

drop table Kierunek;

drop index RELATIONSHIP_7_FK;

drop index RELATIONSHIP_6_FK;

drop index RELATIONSHIP_5_FK;

drop index OCENA_PK;

drop table Ocena;

drop index PROWADZACY_PK;

drop table Prowadzacy;

drop index RELATIONSHIP_3_FK;

drop index RELATIONSHIP_2_FK;

drop index PRZEDMIOT_PK;

drop table Przedmiot;

drop index STUDENT_PK;

drop table Student;

drop index STUDENT_KIERUNEK2_FK;

drop index STUDENT_KIERUNEK_FK;

drop index STUDENT_KIERUNEK_PK;

drop table Student_kierunek;

drop index WYDZIAL_PK;

drop table Wydzial;

/*==============================================================*/
/* Table: Kierunek                                              */
/*==============================================================*/
create table Kierunek (
   Nazwa_kier           VARCHAR(30)          not null,
   Nazwa_wydzialu       VARCHAR(100)         not null,
   constraint PK_KIERUNEK primary key (Nazwa_kier)
);

/*==============================================================*/
/* Index: KIERUNEK_PK                                           */
/*==============================================================*/
create unique index KIERUNEK_PK on Kierunek (
Nazwa_kier
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_1_FK on Kierunek (
Nazwa_wydzialu
);

/*==============================================================*/
/* Table: Ocena                                                 */
/*==============================================================*/
create table Ocena (
   Id_ocena             SERIAL               not null,
   Id_prowadz           INT4                 not null,
   Id_przedmiotu        INT4                 not null,
   Nr_indeksu           INT4                 not null,
   Ocena                INT2                 not null,
   constraint PK_OCENA primary key (Id_ocena)
);

/*==============================================================*/
/* Index: OCENA_PK                                              */
/*==============================================================*/
create unique index OCENA_PK on Ocena (
Id_ocena
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_5_FK on Ocena (
Nr_indeksu
);

/*==============================================================*/
/* Index: RELATIONSHIP_6_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_6_FK on Ocena (
Id_prowadz
);

/*==============================================================*/
/* Index: RELATIONSHIP_7_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_7_FK on Ocena (
Id_przedmiotu
);

/*==============================================================*/
/* Table: Prowadzacy                                            */
/*==============================================================*/
create table Prowadzacy (
   Id_prowadz           SERIAL               not null,
   Imie                 VARCHAR(30)          not null,
   Nazwisko             VARCHAR(50)          not null,
   Email_prowadzacego   VARCHAR(120)         null,
   Nr_telefonu          VARCHAR(14)          null,
   Data_zatrudnienia    DATE                 not null,
   constraint PK_PROWADZACY primary key (Id_prowadz)
);

/*==============================================================*/
/* Index: PROWADZACY_PK                                         */
/*==============================================================*/
create unique index PROWADZACY_PK on Prowadzacy (
Id_prowadz
);

/*==============================================================*/
/* Table: Przedmiot                                             */
/*==============================================================*/
create table Przedmiot (
   Id_przedmiotu        SERIAL               not null,
   Nazwa_kier           VARCHAR(30)          not null,
   Id_prowadz           INT4                 not null,
   Nazwa_przedmiotu     VARCHAR(30)          not null,
   constraint PK_PRZEDMIOT primary key (Id_przedmiotu)
);

/*==============================================================*/
/* Index: PRZEDMIOT_PK                                          */
/*==============================================================*/
create unique index PRZEDMIOT_PK on Przedmiot (
Id_przedmiotu
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_2_FK on Przedmiot (
Nazwa_kier
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_3_FK on Przedmiot (
Id_prowadz
);

/*==============================================================*/
/* Table: Student                                               */
/*==============================================================*/
create table Student (
   Nr_indeksu           SERIAL               not null,
   Imie                 VARCHAR(30)          not null,
   Nazwisko             VARCHAR(50)          not null,
   Email                VARCHAR(50)          not null,
   Nr_telefonu          VARCHAR(14)          null,
   Data_rozpoczecia     DATE                 not null,
   Data_zakonczenia     DATE                 null,
   constraint PK_STUDENT primary key (Nr_indeksu)
);

/*==============================================================*/
/* Index: STUDENT_PK                                            */
/*==============================================================*/
create unique index STUDENT_PK on Student (
Nr_indeksu
);

/*==============================================================*/
/* Table: Student_kierunek                                      */
/*==============================================================*/
create table Student_kierunek (
   Nr_indeksu           INT4                 not null,
   Nazwa_kier           VARCHAR(30)          not null,
   constraint PK_STUDENT_KIERUNEK primary key (Nr_indeksu, Nazwa_kier)
);

/*==============================================================*/
/* Index: STUDENT_KIERUNEK_PK                                   */
/*==============================================================*/
create unique index STUDENT_KIERUNEK_PK on Student_kierunek (
Nr_indeksu,
Nazwa_kier
);

/*==============================================================*/
/* Index: STUDENT_KIERUNEK_FK                                   */
/*==============================================================*/
create  index STUDENT_KIERUNEK_FK on Student_kierunek (
Nr_indeksu
);

/*==============================================================*/
/* Index: STUDENT_KIERUNEK2_FK                                  */
/*==============================================================*/
create  index STUDENT_KIERUNEK2_FK on Student_kierunek (
Nazwa_kier
);

/*==============================================================*/
/* Table: Wydzial                                               */
/*==============================================================*/
create table Wydzial (
   Nazwa_wydzialu       VARCHAR(100)         not null,
   constraint PK_WYDZIAL primary key (Nazwa_wydzialu)
);

/*==============================================================*/
/* Index: WYDZIAL_PK                                            */
/*==============================================================*/
create unique index WYDZIAL_PK on Wydzial (
Nazwa_wydzialu
);

