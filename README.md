# Java-OOP
 
Object oriented konsol uygulaması olacak.

Araç Tipi, Araç Adı, Kapladığı Alan
- Tip : 1 - Bisiklet  - 1 Birim;
- Tip : 2 - Motorsiklet - 1 Birim;
- Tip : 3 - Araba - 2 Birim;
- Tip : 4 - Kamyonet - 3 Birim;
- Tip : 5 - Otobüs - 5 Birim;
- Tip : 6 - Tır -  8 Birim;	

Uygulama başlayınca kullanıcıdan garajın kapasitesi istenecek: 5 ile 50 arası bir değer alınacak. Kullanıcı 5-50 arası değer girinceye kadar uygulama başlamayacak.

Uygulama başlayınca Text dosyasında var olan araçlar eklenir.

Daha Sonra kullanıcıdan giriş yapması istenecek
- G TIP Örnek: G-3-43UG566
- C TIP Örnek: C-3-43UG566

değerleri geçerli olacak.

G değeri ile garaja verilen plaka ve tip değerine göre araç Text dosyasına eklenecek. Eğer garajda yer müsait ise araç yerleşecek. Kullanıcı bilgilendirilecek. Yer yoksa kullanıcıya hata mesajı verilecek.

C değeri ile garaja verilen plaka ve tip değerine göre araç Text dosyasından cıkarılacak. Eğer garajda o tipte araç yoksa kullanıcı uyarılacak.

L komutu ile garajdaki araçlar listelenecek.

Her giriş ve her çıkışta garajdaki mevcut yer durumu gösterilecek.

- 2 adet design pattern kullanımı zorunlu.
- Abstract class ya da interface kullanımı zorunlu

Design Pattern Kullanımları:
- Kullanıcıdan Giriş istenirken Command(Komut) kullanıldı.
- Garaj kalan alan kısmında Observer(Gözlemci) kullanıldı.
