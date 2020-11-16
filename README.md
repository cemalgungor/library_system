# Kütüphane Yönetim Uygulaması

Bu projenin amacı kitap yönetimi için kolaylık sağlamaktır.Bu proje geliştirme aşamasındadır.

#### Nasıl Kitap,Yazar ve Yayın Evi eklerim?

Bu projede 3 adet ana alan vardır.Bunlar kitap,yayın evi ve yazar alanlarıdır. Öncelikle bir kitap eklerken yazar ve yayın evini eklemelisiniz.
Sadece önceden eklenilen yazarlara ve yayın evleri için kitap yazarı ve yayın evi eklenilir.Bu sistem ilerde daha düzenli hale getirilecektir.
Ardından kitap eklerken gerekli bilgiler doldurulduktan sonra yayın evi ve yazar'da seçilerek kitap ekleme işlemi tamamlanır.

## Nasıl Kullanırım?

Bu projeyi kullanırken sadece repositoryi klonlayarak kendi ideniz üzerinizden çalıştırmanız gerekmektedir.Herhangi bir şekilde tablo ve veri oluşturmanıza gerek yoktur.
Yalnızca bir veritabanı oluşturup application.properties dosyası üzerinden gerekli ayarları yapmalısınız.

## Kullanılan Teknolojiler ve Neden Kullanıldığı

#### Spring Boot: 
 Spring Boot,Spring tabanlı uygulama geliştirmenin hızlı ve kolay yönünü sunar.Spring boot kullanarak herhangi bir xml konfigurasyonuyla uğraşmayız. Ayrıca web sunucusu olan tomcat
 projemizde gömülü olarak gelmektedir herhangi bir ayar gereksinimi yoktur.
 
 #### Spring MVC: 
 MVC mimarisi kullanılarak web tabanlı projeler geliştirmeye imkan sağlanılır. Uygulama verileri model katmanında, kullanıcıya döndüreceğimiz sayfa view katmanında, ve iş katmanı
 olan controller katmanı vardır.
 
 #### Thymleaf:
 Uygulama için ön yüz geliştirilmek istenmiş bunun için springle uyumlu olan hemde daha basit bir kullanım sunan thymleaf seçilmiştir.
 
 #### Spring Data JPA:
 Veritabanı işlemleri için kullanılan spring datayla, veritabanı için crud işlemlerini çok daha basit bir şekilde gerçekleştiririz. Kendine özgü olan methodları çağırarak 
 neredeyse hiç kod yazmadan işlemlerimizi gerçekleştirebiliriz.
 
  #### Maven:
  Maven geliştiriciyi uygulama için gerekli kütüphanelerin eklenmesi,indirilmesi vs ile uğraştırmadan geliştiriciye kolaylık sağlar.
  
  #### Rest: 
  Rest ile istemciden gelen istekleri karşılayıp isteğe göre bir cevap göndeririz.Bunu Http methodları vasıtasıyla yapmaktayız.
  
  #### Postgre SQL:
   Hem ilişkisel bir veritabanı sunması hem de açık kaynaklı ve ücretsiz olması sebebiyle tercih edilmiştir.
   
   # Ekran Görünteleri
   Öncelikle yazın evi eklenildi.
   
![Image](https://github.com/cemalgungor/library_system/blob/master/publisher.png)
   Ardından yazar eklenildi.
   ![Image](https://github.com/cemalgungor/library_system/blob/master/authorr.png)
 Ardından Kitap eklenildi.
  ![Image](https://github.com/cemalgungor/library_system/blob/master/book.png)
