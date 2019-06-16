<template>
    <table>
      <thead>
        <tr>
          <th>#</th>
          <th>Name</th>
          <th>Amount</th>
          <th>Quantity</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(sale, idx) in vendorSales" :key="sale.vendorKey">
          <td>{{ idx + 1}}</td>
          <td>{{ sale.vendorName }}</td>
          <td>{{ sale.amountTotal }}</td>
          <td>{{ sale.quantityTotal }}</td>
        </tr>
      </tbody>
  </table>

</template>

<script>

export default {
    name : 'sales-grid',
    data() {
      return {
        vendorSales : []
      }  
    },
    mounted() {

      this.$sse('/sales/1/stream', { format: 'json' }).then(sse => {
  
        sse.subscribe('sales-event', (message) => {
          console.log(message);

          this.vendorSales.push({
            vendorName : message.vendor.vendorName,
            amountTotal : message.value,
            quantityTotal : message.quantity
          })
        });

      });
    }
}
</script>

<style scoped>

</style>