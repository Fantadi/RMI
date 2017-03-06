
create table client (
   id                   serial               not null,
   nom                varchar(50)          not null,
   prenom             varchar(50)          not null,
   login              varchar(50)           not null,
   mdp                varchar(50)           not null,
   
   constraint pk_client primary key (id),
   constraint login_uc unique (login)
);


create table compte (
   id                   serial               not null,
   client               integer               not null,
   numerocpt            varchar(255)          not null,
   solde                double precision      not null DEFAULT 0.0,
   constraint pk_compte primary key (id),
    constraint numerocpt_uc unique (numerocpt)
);

alter table compte
   add constraint fk_compte_1_client foreign key (client)
      references client (id)
      on delete restrict on update restrict;

