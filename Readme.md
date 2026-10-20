# Veri Yapıları

Bu depo, temel veri yapılarının Java ile elle uygulanmış örneklerini ve bazıları için küçük çalıştırma senaryolarını içerir. Proje, veri yapılarını ve temel işlemlerini incelemek/öğrenmek amacıyla hazırlanmıştır; üretim kullanımı için doğrulanmış bir kütüphane değildir.

## İçindekiler

- [Projedeki yapılar](#projedeki-yapılar)
- [Proje düzeni](#proje-düzeni)
- [Derleme ve çalıştırma](#derleme-ve-çalıştırma)
- [Kapsam ve bilinen sınırlamalar](#kapsam-ve-bilinen-sınırlamalar)

## Projedeki yapılar

| Yapı | Uygulama ve örnek | Açıklama |
| --- | --- | --- |
| Tek bağlı liste | `LinkedList.linkedList`, `LinkedList.Main` | Başa/sona ekleme, belirli bir değerden önce ekleme, arama, baştan/sondan silme ve kopyalama örnekleri. |
| Yığın (Stack) | `LinkedList.StackStructure.Stack`, `LinkedList.StackStructure.Main` | Bağlı liste düğümleriyle `push` ve `pull` işlemleri. |
| Kuyruk (Queue) | `LinkedList.QueueStructure.Queue`, `LinkedList.QueueStructure.Main` | Bağlı liste düğümleriyle kuyruğa ekleme ve kuyruktan alma örneği. |
| İkili arama ağacı (BST) | `BinarySearchTree.Node`, `BinarySearchTree.Main` | Ekleme, sıralı/dolaşım gezintileri, en küçük/en büyük değeri bulma, arama, ebeveyn arama ve silme. |
| AVL ağacı | `AVL_Tree.AVL`, `AVL_Tree.AVL_agaci`, `AVL_Tree.AnaSinif` | Yükseklik bilgisi ve rotasyonlarla ekleme/dengelemeye yönelik örnek. |
| Hash table | `HashTable.KarmaBagliListe`, `HashTable.KarmaDizi`, `HashTable.AnaSinif` | Modulo tabanlı hash fonksiyonu; çakışmalar için bağlı liste örneği ve doğrudan dizi örneği. |
| Min-heap | `MinHeapTree.MinHeap` | Dizi tabanlı min-heap ekleme ve kökten eleman çekme işlemleri. Bu sınıf için henüz bir demo `main` metodu yoktur. |

## Proje düzeni

```text
src/
├── AVL_Tree/                 # AVL düğümü, ağaç ve örnek program
├── BinarySearchTree/         # İkili arama ağacı ve örnek program
├── HashTable/                # Hash tablosu örnekleri ve örnek program
├── LinkedList/               # Tek bağlı liste ve örnek program
│   ├── QueueStructure/       # Kuyruk ve örnek program
│   └── StackStructure/       # Yığın ve örnek program
└── MinHeapTree/              # Min-heap uygulaması
```

Her klasör Java paketini temsil eder. Proje kökündeki `DataStructure.iml`, `src` klasörünü IntelliJ IDEA kaynak klasörü olarak tanımlar.

## Derleme ve çalıştırma

Bir JDK kurulu olmalı; `javac` ve `java` komutları terminalden erişilebilir olmalıdır. Aşağıdaki komutlar Windows PowerShell içindir ve tüm kaynak dosyalarını `out` klasörüne derler:

```powershell
$sources = Get-ChildItem .\src -Recurse -Filter *.java | ForEach-Object { $_.FullName }
New-Item -ItemType Directory -Force .\out | Out-Null
javac -d .\out $sources
```

Derleme başarılı olduktan sonra örnek programları paket adlarıyla çalıştırabilirsiniz:

```powershell
java -cp .\out LinkedList.Main
java -cp .\out LinkedList.StackStructure.Main
java -cp .\out LinkedList.QueueStructure.Main
java -cp .\out BinarySearchTree.Main
java -cp .\out AVL_Tree.AnaSinif
java -cp .\out HashTable.AnaSinif
```

`MinHeapTree.MinHeap` ve `HashTable.KarmaDizi` için şu anda ayrı bir komut satırı örneği bulunmuyor; sınıflar başka bir Java kodundan oluşturulup kullanılabilir.

## Kapsam ve bilinen sınırlamalar

- README'de önceki sürümde yer alan **B++ Tree** başlığına rağmen kaynak kodda B++ ağaç uygulaması bulunmuyor.
- Örnekler temel algoritma fikirlerini göstermek içindir. Boş yapı, tek eleman, kapasite sınırı ve silme gibi uç durumların tamamı güvenilir biçimde ele alınmış değildir.
- Özellikle `MinHeap` içindeki kökten eleman çekme ve aşağı doğru heap düzenleme işlemleri sınır kontrolleri açısından geliştirilmelidir.
- Bağlı listedeki baştan silme, yığından son elemanı çekme ve kuyruktan tek elemanı alma gibi işlemlerde uç durumlarda uç düğüm referanslarının güncellenmesi gerekir.
- `KarmaDizi` çakışma çözümü uygulamaz; aynı indekse hashlenen bir değer önceki değerin üzerine yazabilir. `KarmaBagliListe` çakışmaları bağlı listede saklama yaklaşımını gösterir.
- Sınıf/metot adları ve açıklamaların bir bölümü Türkçe, bir bölümü İngilizcedir; bu depo için otomatik test veya paket yöneticisi yapılandırması bulunmuyor.
