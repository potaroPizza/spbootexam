--�ڷ�� ���̺�
drop table reboard  cascade constraint;
create table reboard
(
    no                number        primary key,    --��ȣ
    name         varchar2(20)    not null,            --�̸�    
    pwd              varchar2(20)    not null,            --��й�ȣ
    title             varchar2(100)   not  null,            --����
    email          varchar2(80)    null,            --�̸���
    regdate     date        default  sysdate,    --�ۼ���    
    readcount    number        default 0     null,        --��ȸ��
    content         clob         null,            --����
    groupNo            number          default 0,           --�׷��ȣ
    step           number           default 0,          --���� �ܰ� 
    sortNo         number           default 0,       --���� ���ļ���
    delFlag         char     default 'N',             --���� Flag
    fileName    varchar2(150)     null,                      --���ε����ϸ�
    fileSize    number            default 0,                      --���ϻ����� 
    downCount    number     default 0,            --�ٿ��
    originalFileName    varchar2(50)     null               --������ ���ϸ�	
);

drop sequence reboard_seq;
create sequence reboard_seq
increment by 1
start with 1
nocache;

select * from reboard order by no desc;

alter table book add fileName varchar2(150) null;
alter table book add fileSize number            default 0;
alter table book add downCount number     default 0;
alter table book add originalFileName varchar2(50) null;

select * from book;

commit;
